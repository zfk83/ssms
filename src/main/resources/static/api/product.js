function getProducts() {
    return request({
        url: '/product/list',
        method: 'get'
    });
}

function addProduct(data) {
    return request({
        url: '/product/add',
        method: 'post',
        data: data
    });
}

function updateProduct(data) {
    return request({
        url: '/product/update',
        method: 'put',
        data: data
    });
}

function deleteProduct(id) {
    return request({
        url: '/product/delete/' + id,
        method: 'delete'
    });
}

function getProduct(id) {
    return request({
        url: '/product/get/' + id,
        method: 'get'
    });
}