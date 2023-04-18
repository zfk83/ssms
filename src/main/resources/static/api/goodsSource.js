function getGoodsSources(id){
    return request({
        url: '/goodsSource/list?providerId=' + id,
        method: 'get'
    });
}