import React from 'react'
import classnames from 'classnames'
import { withRouter } from 'react-router-dom'

class LoginFrom extends React.Component {



  constructor(props) {
    super(props)

    this.state = {
      elements: '',
      wb1: '',
      wb2: ''
    }
  }



  onSubmit = (e) => {
    e.preventDefault();

    // login successful or not
    this.props.loginAction.userloginAction(this.state).then(
      // success
      (res) => {
        if (res.code != "0") {
          alert(res.msg);
        } else {
          this.setState({ wb1: res.data.fibonacci, wb2: res.data.sorted })

        }
      },
      // fail
      (err) => {
      }
    )


  }

  onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value })
  }

  render () {

    const { elements, wb1, wb2 } = this.state

    var divStyle = {
      height: "100px"
    };

    return (

      <form onSubmit={this.onSubmit}>
        <div style={divStyle}></div>
        <div className="form-group">
          <label className="control-label">please input a num (ps:num between 1 to 100)  </label>
          <input
            className="form-control"
            type="text"
            name="elements"
            value={elements}
            onChange={this.onChange}
          />
        </div>

        <div className="form-group">
          <label className="control-label">fibonacci  </label>
          <input
            className="form-control"
            type="text"
            name="wb1"
            value={wb1}
            onChange={this.onChange}
            readOnly
          />
        </div>

        <div className="form-group">
          <label className="control-label">sorted  </label>
          <input
            className="form-control"
            type="text"
            name="wb2"
            value={wb2}
            onChange={this.onChange}
            readOnly
          />
        </div>

        <div className="form-group">
          <button type="submit" className="btn btn-primary btn-md">submit</button>
        </div>
      </form>
    )
  }
}


export default withRouter(LoginFrom)
