var main = {
    init : function () {
        var _this = this;

        $('#btn-addCart').on('click', function () {
            _this.addCart();
        });

        $('#btn-saveReview').on('click', function () {
            _this.saveReview();
        });

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

    },
    saveReview : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
            rate: 0,
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/products/'+ $('#product_id')[0].innerHTML + '/reviews',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/product/'+ $('#product_id')[0].innerHTML;
        }).fail(function (error) {
            //alert(JSON.stringify(error));
            alert('로그인이 필요한 서비스입니다.');
        });
    },
    addCart : function () {

        user = $('#user_id')[0];

        if(user != undefined) {
            var data = {
                userId: $('#user_id')[0].innerHTML*1,
                productId: $('#product_id')[0].innerHTML*1,
                productCount: $('#product_count').val(),
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/carts',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('장바구니에 등록 되었습니다.');
                window.location.href = '/product/'+ $('#product_id')[0].innerHTML;;
            }).fail(function (error) {
                //alert(JSON.stringify(error));
                alert('로그인이 필요한 서비스입니다..');
            });
        }else{
            alert('로그인이 필요한 서비스입니다.');
        }
    },
    updateCart : function (cartId) {
        var data = {
            cartId,
            productId: 0, //null
            productCount: $('#product_count_' + cartId).val(),
        };

        $.ajax({
            type: 'PUT',
            url: '/api/v1/carts/',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('수정 성공');
            window.location.href = '/carts';
        }).fail(function (error) {
            //alert(JSON.stringify(error));
            alert('수정 실패');
        });

    },
    deleteCart : function (cartId) {

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/carts/' + cartId,
            //dataType: 'json', //서버에서 올 데이터 타입
            //contentType: 'application/json; charset=utf-8', //서버로 보내는 request body의 타입
            //data: JSON.stringify(data) //서버로 보내는 데이터
        }).done(function () {
            alert('삭제 성공');
            window.location.href = '/carts';
        }).fail(function (error) {
            //alert(JSON.stringify(error));
            alert('삭제 실패');
        });

    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/posts';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/posts';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/posts';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();


ratings = document.querySelectorAll('div.RatingStar')
totalRating = 5;

ratings.forEach((el) => {
    rate = el.querySelector('span.rate-value').innerText;

    ratingPercentage = rate / totalRating * 100;
    ratingRounded = Math.round(ratingPercentage / 10) * 10 + '%';

    star = el.querySelector(`div.inner-star`);
    star.style.width = ratingRounded;
});