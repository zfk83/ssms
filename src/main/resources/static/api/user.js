function login(data){
    return request({
        url: '/user/login',
        method: 'post',
        data: data
    })
}

function register(data){
    return request({
        url: '/user/register',
        method: 'post',
        data: data
    })
}