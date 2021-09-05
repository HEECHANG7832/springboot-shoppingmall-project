var productListMain = {
    init : function () {
        var _this = this;

        $('#btn-searchProduct').on('click', function () {
            _this.searchProduct();
        });
    },
    searchProduct : function () {
        alert('queyr');
        var data = {
        };

        $.ajax({
            type: 'GET',
            url: '/api/v1/products/'+  $('#search').val(),
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(products) {
            alert('조회 성공');
            alert(products);

            var productCard = "<div className='col-md-4 col-sm-6'>" +
                "<div className='product-grid8' style=' cursor: pointer;' onClick='location.href='/product/{{id}}''>" +
                "<div className='product-image8'>" +
                " <a href='#'>" +
                "<img className='pic-1' src='{{titleImg}}'>" +
                "<img className='pic-2' src='{{titleImg}}'>" +
                "</a>" +
                "<span className='product-discount-label'>-{{saleRate}}%</span>" +
                "</div>" +
                "<div className='product-content'>" +
                "<div className='price'>$ {{price}} </div>" +
                "<div className='RatingStar'>" +
                "<div className='RatingScore'>" +
                "<span className='rate-value' id='rate'>{{rateAvg}}</span>" +
                "<div className='outer-star'>" +
                "<div className='inner-star'></div>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "<span className='product-shipping'> + ${{shippingCost}} Shipping</span>" +
                "<h3 className='title'><a href='#'>{{productName}}</a></h3>" +
                "</div>" +
                "</div>" +
                "</div>";

            productContainer = document.querySelector('#product-list-container')
            productContainer.innerHTML += productCard;

        }).fail(function (error) {
            //alert(JSON.stringify(error));
            alert('해당 상품은 존재하지 않습니다');
        });
    }
};

productListMain.init();


//productlist page button
pageCount = document.querySelector("#page-count").innerHTML * 1
currentPage = document.querySelector("#current-page").innerHTML * 1 + 1

container = document.querySelector("#page-container")

for(var i = 1; i <= pageCount; i++)
{
    if(i == currentPage){
        container.innerHTML += "<a href=\"/productlist/"+ i +"\" class=\"list-group-item active m-2\" >"+ i +"</a>";
    }else{
        container.innerHTML += "<a href=\"/productlist/"+ i +"\" class=\"list-group-item m-2\" >"+ i +"</a>";
    }
}