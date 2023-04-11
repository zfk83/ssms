function getPurchases(){
    return request({
        url: '/purchase/list',
        method: 'get'
    });
}

function addPurchase(data){
    return request({
        url: '/purchase/add',
        method: 'post',
        data: data
    });
}

function updatePurchase(data){
    return request({
        url: '/purchase/update',
        method: 'put',
        data: data
    });
}

function deletePurchase(id){
    return request({
        url: '/purchase/delete?id=' + id,
        method: 'delete'
    });
}

function getPurchase(purchaseId){
    return request({
        url: '/purchase/get?purchaseId=' + purchaseId,
        method: 'get'
    });
}