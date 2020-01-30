import React from 'react';
import { Switch } from 'react-router-dom';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import EfekMySuffix from './efek-my-suffix';
import HargaPenutupanMySuffix from './harga-penutupan-my-suffix';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}efek-my-suffix`} component={EfekMySuffix} />
      <ErrorBoundaryRoute path={`${match.url}harga-penutupan-my-suffix`} component={HargaPenutupanMySuffix} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
