window.onload = async function(){
    await fetchGames();
    /* await fetchBehavior();*/
}

async function fetchGames()
{
    let uri = "http://localhost:8080/games";
    let config = {
        method : "get"
    };

    let response = await fetch(uri,config);
    let json = await response.json();
    let section = document.querySelector("table");
    for(let i = 0; i < json.length; i ++)
    {
        let element = json[i];
        addElement(element,section);
    }
}
async function fetchBehavior()
{
    let uri = "http://localhost:8080/behavior";
    let config = {
        method : "get"
    };

    let response = await fetch(uri,config);
    let json = await response.json();
    let section = document.getElementById("table");
    for(let i = 0; i < json.length; i ++)
    {
        let element = json[i];
        addBehavior(element,section);
    }
}
function addElement(element, section)
{
    /*Game Objects*/
    let id  = document.createElement("td");
    let name = document.createElement("td");
    let genres = document.createElement("td");
    let platforms = document.createElement("td");
    let developer = document.createElement("td");
    let date = document.createElement("input");
    date.setAttribute("type","date");
    id.innerText = element.id;
    name.innerText = element.name;
    genres.innerText = element.genres;
    platforms.innerText = element.platforms;
    developer.innerText = element.developers;
    section.appendChild(id);
    section.appendChild(name);
    section.appendChild(date);
    section.appendChild(genres);
    section.appendChild(platforms);
    section.appendChild(developer);
    section.appendChild(document.createElement("tr"));
}

function addBehavior(behavior,section)
{
    /*Game Objects*/
    let id  = document.createElement("p");
    let name = document.createElement("p");
    let purchase = document.createElement("p");
    let price = document.createElement("p");
    let hoursplayedaverage = document.createElement("p");
    id.innerText = "ID:" + behavior.id;
    name.innerText = "Behavior' name: " + behavior.name;
    purchase.innerText = "purchase: " + behavior.purchase;
    price.innerText = "price: $" + behavior.price;
    hoursplayedaverage.innerText = "hoursplayedaverage: " + behavior.hoursplayedaverage;
    section.appendChild(id);
    section.appendChild(name);
    section.appendChild(purchase);
    section.appendChild(price);
    section.appendChild(hoursplayedaverage);
}