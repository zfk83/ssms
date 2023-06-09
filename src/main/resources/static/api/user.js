function getUsers(){
    return request({
        url: '/user/list',
        method: 'get'
    })
}

function addUser(data){
    return request({
        url: '/user/add',
        method: 'post',
        data: data
    })
}

function updateUser(data){
    return request({
        url: '/user/update',
        method: 'put',
        data: data
    })
}

function deleteUser(id){
    return request({
        url: '/user/delete?id=' + id,
        method: 'delete'
    })
}

function getUser(params){
    return request({
        url: '/user/get/',
        method: 'get',
        params: params
    })
}

function getUserById(id){
    return request({
        url: '/user/getById?id=' + id,
        method: 'get'
    })
}

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