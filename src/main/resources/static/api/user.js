function login(data){
    return request({
        url: '/user/login',
        method: 'post',
        data: data
    })
}

function register(data){
    return request({
        url: '/user/add',
        method: 'post',
        data: data
    })
}

