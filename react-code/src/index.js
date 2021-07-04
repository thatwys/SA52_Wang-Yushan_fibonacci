import React from 'react';
import ReactDOM from 'react-dom';


//
import logger from 'redux-logger'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'

// redux 
import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'

import rootReducer from './reducers'

import routes from './routes'
import { BrowserRouter as Router, BrowserRouter, Route } from 'react-router-dom'



import Decode from 'jwt-decode'

const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(logger, thunk)))




ReactDOM.render(
  <Provider store={store}>
    <Router routes={routes}>
      {routes}
    </Router>
  </Provider>
  ,
  document.getElementById('root')
);

