import axios from 'axios'




export const userloginAction = (data) => {
  return dispatch => {
    return axios.post("/api/fibonacci", data).then(res => {

      return res.data;

    })
  }
}