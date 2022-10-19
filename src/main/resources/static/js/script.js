/**

*/
	var b = document.querySelectorAll("#footer");
	for(var i = 0; i < b.length;i++){
    	if(b[i].innerText == ""){
    		b[i].outerHTML = "";
	}
   }
   
const slide_show_img = document.querySelectorAll(".slideContainer .slide");
const time_for_show_img = 5000;
let count_img = 0;

slide_show_img[count_img].style.opacity = 1;

setInterval(nextImg, time_for_show_img)

function nextImg(){
	slide_show_img[count_img].style.opacity = 0;
	count_img = (count_img + 1)% slide_show_img.length;
	slide_show_img[count_img].style.opacity = 1;
}