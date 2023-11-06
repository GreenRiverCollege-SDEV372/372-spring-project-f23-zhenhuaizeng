window.onload = async function(){
    await fetchGames();
    await fetchBehavior();
}

async function fetchGames()
{
    let uri = "http://localhost:8080/games";
    let config = {
        method : "get"
    };

    let response = await fetch(uri,config);
    let json = await response.json();
    let section = document.querySelector("#table");
    for(let i = 0; i < json.length; i ++)
    {
        let element = json[i];
        addElement(element,section);
        console.log(json[i]);
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
    let section = document.querySelector("#table");
    for(let i = 0; i < json.length; i ++)
    {
        let element = json[i];
        addBehavior(element,section);
        console.log(json[i]);
    }
}
function addElement(element, section)
{
    /*Game Objects*/
    let id  = document.createElement("th");
    let name = document.createElement("th");
    let genres = document.createElement("th");
    let platforms = document.createElement("th");
    let developer = document.createElement("th");
    id.innerText = "ID:" + element.id;
    name.innerText = "Games' name: " + element.name;
    genres.innerText = "Genres: " + element.genres;
    platforms.innerText = "Platforms: " + element.platforms;
    developer.innerText = "Developer: " + element.developers;
    section.appendChild(id);
    section.appendChild(name);
    section.appendChild(genres);
    section.appendChild(platforms);
    section.appendChild(developer);
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