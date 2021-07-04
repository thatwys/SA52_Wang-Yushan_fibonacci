
import React from 'react'
import { Route } from 'react-router-dom'
import APP from './components/App'
import LoginPage from './components/login/LoginPage'



export default (
  <div>
    <Route path="/" component={LoginPage}></Route>
  </div>
)