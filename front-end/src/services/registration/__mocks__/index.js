export default {
  register (detail) {
    return new Promise((resolve, reject) => {
      const errResp = {
        status: 400,
        response: {
          data:{
            message: 'User already exist'
          }
        }
      };
      detail.emailAddress === 'sunny@taskagile.com'
        ? resolve({result: 'success'})
        : reject(errResp)
    })

  }
}
