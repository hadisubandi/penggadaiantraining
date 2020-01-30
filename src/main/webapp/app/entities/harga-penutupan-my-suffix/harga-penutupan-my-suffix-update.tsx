import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IEfekMySuffix } from 'app/shared/model/efek-my-suffix.model';
import { getEntities as getEfeks } from 'app/entities/efek-my-suffix/efek-my-suffix.reducer';
import { getEntity, updateEntity, createEntity, reset } from './harga-penutupan-my-suffix.reducer';
import { IHargaPenutupanMySuffix } from 'app/shared/model/harga-penutupan-my-suffix.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IHargaPenutupanMySuffixUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const HargaPenutupanMySuffixUpdate = (props: IHargaPenutupanMySuffixUpdateProps) => {
  const [efekId, setEfekId] = useState('0');
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { hargaPenutupanEntity, efeks, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/harga-penutupan-my-suffix' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }

    props.getEfeks();
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...hargaPenutupanEntity,
        ...values
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="backendtrainingApp.hargaPenutupan.home.createOrEditLabel">Create or edit a HargaPenutupan</h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : hargaPenutupanEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="harga-penutupan-my-suffix-id">ID</Label>
                  <AvInput id="harga-penutupan-my-suffix-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="tanggalLabel" for="harga-penutupan-my-suffix-tanggal">
                  Tanggal
                </Label>
                <AvField
                  id="harga-penutupan-my-suffix-tanggal"
                  type="date"
                  className="form-control"
                  name="tanggal"
                  validate={{
                    required: { value: true, errorMessage: 'This field is required.' }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="hargaLabel" for="harga-penutupan-my-suffix-harga">
                  Harga
                </Label>
                <AvField
                  id="harga-penutupan-my-suffix-harga"
                  type="string"
                  className="form-control"
                  name="harga"
                  validate={{
                    min: { value: 0, errorMessage: 'This field should be at least 0.' },
                    number: { value: true, errorMessage: 'This field should be a number.' }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label for="harga-penutupan-my-suffix-efek">Efek</Label>
                <AvInput id="harga-penutupan-my-suffix-efek" type="select" className="form-control" name="efek.id">
                  <option value="" key="0" />
                  {efeks
                    ? efeks.map(otherEntity => (
                        <option value={otherEntity.id} key={otherEntity.id}>
                          {otherEntity.id}
                        </option>
                      ))
                    : null}
                </AvInput>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/harga-penutupan-my-suffix" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">Back</span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp; Save
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  efeks: storeState.efek.entities,
  hargaPenutupanEntity: storeState.hargaPenutupan.entity,
  loading: storeState.hargaPenutupan.loading,
  updating: storeState.hargaPenutupan.updating,
  updateSuccess: storeState.hargaPenutupan.updateSuccess
});

const mapDispatchToProps = {
  getEfeks,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(HargaPenutupanMySuffixUpdate);
