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
        url: '/product/delete?id=' + id,
        method: 'delete'
    });
}

function getProduct(productId) {
    return request({
        url: '/product/get?productId=' + productId,
        method: 'get'
    });
}