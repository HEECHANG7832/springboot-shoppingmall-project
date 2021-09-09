carts = document.querySelectorAll("#cart");
var sum = 0
carts.forEach((el) => {
    price = el.querySelector("#price").innerHTML;

    productCount = el.querySelector('input[name="product_count"]').value;

    sum += (price.substr(1, price.length) * productCount);
});

console.log(sum);

subtotal = document.querySelector("#subtotal");
subtotal.innerHTML = '$' + sum;