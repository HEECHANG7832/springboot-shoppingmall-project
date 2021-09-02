
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