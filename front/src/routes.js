import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import One from "./one";
import Two from "./two";
import Three from "./three";
import Four from "./four";

export default function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/1" component={One} />
        <Route exact path="/2" component={Two} />
        <Route exact path="/3" component={Three} />
        <Route exact path="/4" component={Four} />
      </Switch>
    </BrowserRouter>
  );
}
