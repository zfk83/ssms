function getProviders(){
    return request({
        url: '/provider/list',
        method: 'get'
    });
}

function addProvider(data){
    return request({
        url: '/provider/add',
        method: 'post',
        data: data
    });
}

function updateProvider(data){
    return request({
        url: '/provider/update',
        method: 'put',
        data: data
    });
}

function deleteProvider(id){
    return request({
        url: '/provider/delete?id=' + id,
        method: 'delete'
    });
}

function getProvider(params){
    return request({
        url: '/provider/get',
        method: 'get',
        params: params
    });
}

function getProviderById(id){
    return request({
        url: '/provider/getById?id=' + id,
        method: 'get'
    });
}