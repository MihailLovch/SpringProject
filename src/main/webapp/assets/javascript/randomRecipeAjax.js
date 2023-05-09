document.addEventListener("DOMContentLoaded", function () {
    const fetchDataBtn = document.getElementById("fetchDataBtn");
    const recipeImage = document.getElementById("recipeImage");
    const calories = document.getElementById("calories");
    const fats = document.getElementById("fats");
    const carbs = document.getElementById("carbs");
    const info = document.getElementById("info");
    const recipe = document.getElementById("recipe");

    fetchDataBtn.addEventListener("click", ()=> {
        const xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function (){
            if (xhr.readyState === XMLHttpRequest.DONE ){
                if (xhr.status === 200) {
                    const response = JSON.parse(xhr.responseText);

                    recipeImage.setAttribute("src",response.imageUrl);

                    calories.innerText = "Calories:" + response.calories;
                    carbs.innerText = "Carbs:" + response.carbs;
                    fats.innerText = "Fats:" + response.fats;

                    info.innerHTML = response.information
                    recipe.innerHTML = response.instruction

                }else{
                    alert("Something bad happened,please try again")
                }
            }
        };
        xhr.open("GET","/api/random-recipe",true)
        xhr.send();
    });
});