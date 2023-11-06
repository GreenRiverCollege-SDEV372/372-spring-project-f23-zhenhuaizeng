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
    let section = document.querySelector("table");
    let idTitle = document.createElement("th");
    let dateTitle = document.createElement("th");
    dateTitle.setAttribute("type","date");
    let BehaviorTitle = document.createElement("th");
    let purchaseTitle = document.createElement("th");
    let priceTitle = document.createElement("th");
    let hourseTitle = document.createElement("th");
    idTitle.innerText = "ID";
    BehaviorTitle.innerText = "Behavior Name";
    purchaseTitle.innerText = "Purchase";
    priceTitle.innerText = "Price";
    hourseTitle.innerText = "HoursPlayedAverage"
    section.appendChild(idTitle);
    section.appendChild(dateTitle);
    section.appendChild(BehaviorTitle);
    section.appendChild(purchaseTitle);
    section.appendChild(priceTitle);
    section.appendChild(hourseTitle);
    section.appendChild(document.createElement("tr"));
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
    let id  = document.createElement("td");
    let name = document.createElement("td");
    let purchase = document.createElement("td");
    let price = document.createElement("td");
    let hoursplayedaverage = document.createElement("td");
    let date = document.createElement("input");
    date.setAttribute("type","date");
    id.innerText = behavior.id;
    name.innerText = behavior.name;
    purchase.innerText = behavior.purchase;
    price.innerText = "$" + behavior.price;
    hoursplayedaverage.innerText = behavior.hoursplayedaverage;
    section.appendChild(id);
    section.appendChild(name);
    section.appendChild(date);
    section.appendChild(purchase);
    section.appendChild(price);
    section.appendChild(hoursplayedaverage);
    section.appendChild(document.createElement("tr"));
}