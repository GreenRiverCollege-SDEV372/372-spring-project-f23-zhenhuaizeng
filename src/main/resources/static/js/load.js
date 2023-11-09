window.onload = async function(){
    await fetchGames();
    await fetchBehavior();
    clickCell();
    let button = document.querySelector("#button");
    button.onclick = addRecord;

}

//show him the event.preventDefault();
async function addRecord() {
    let newRecord = {
        name : document.querySelector("input#GName").value,
        genres :document.querySelector("input#Genres").value,
        platforms :document.querySelector("input#Platforms").value,
        developers : document.querySelector("input#Developers").value
    };
    console.log(newRecord);
    let uri = "http://localhost:8080/games/add";
    let config =
        {
            method : "post",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newRecord)
        };
    let response = await fetch(uri,config);
    let json =  await response.json();
    let section = document.querySelector("#title");
    addElement(json,section);

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
    let submit = document.createElement("th");
    let BehaviorTitle = document.createElement("th");
    let purchaseTitle = document.createElement("th");
    let priceTitle = document.createElement("th");
    let hourseTitle = document.createElement("th");
    let edit = document.createElement("th");
    let deletee = document.createElement("th");
    edit.innerText = "Edit";
    deletee.innerText = "Delete";
    idTitle.innerText = "ID";
    BehaviorTitle.innerText = "Behavior Name";
    purchaseTitle.innerText = "Purchase";
    priceTitle.innerText = "Price";
    hourseTitle.innerText = "HoursPlayedAverage"
    submit.innerText = "Submitted";
    section.appendChild(idTitle);
    section.appendChild(submit);
    section.appendChild(BehaviorTitle);
    section.appendChild(purchaseTitle);
    section.appendChild(priceTitle);
    section.appendChild(hourseTitle);
    section.appendChild(edit);
    section.appendChild(deletee);
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
    let edit = document.createElement("td");
    let deletee = document.createElement("td");
    date.setAttribute("type","date");
    id.innerText = element.id;
    name.innerText = element.name;
    genres.innerText = element.genres;
    platforms.innerText = element.platforms;
    developer.innerText = element.developers;
    edit.innerHTML = '<a class = "edit" href = "#" > Edit </a>';
    deletee.innerHTML= '<a class = "delete" href = "#"> Delete </a>';
    section.appendChild(id);
    section.appendChild(date);
    section.appendChild(name);
    section.appendChild(genres);
    section.appendChild(platforms);
    section.appendChild(developer);
    section.appendChild(edit);
    section.appendChild(deletee);
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
    let edit = document.createElement("td");
    let deletee = document.createElement("td");
    id.innerText = behavior.id;
    name.innerText = behavior.name;
    purchase.innerText = behavior.purchase;
    price.innerText = "$" + behavior.price;
    hoursplayedaverage.innerText = behavior.hoursplayedaverage;
    edit.innerHTML = '<a class = "edit" href = "#" > Edit </a>';
    deletee.innerHTML= '<a class = "delete" href = "#"> Delete </a>';
    section.appendChild(id);
    section.appendChild(date);
    section.appendChild(name);
    section.appendChild(purchase);
    section.appendChild(price);
    section.appendChild(hoursplayedaverage);
    section.appendChild(edit);
    section.appendChild(deletee);
    section.appendChild(document.createElement("tr"));
}

function clickCell() {
    var edit = document.querySelectorAll(".edit");
    for (let i = 0; i < edit.length; i++)
    {
        edit[i].addEventListener("click",function ()
        {
            edit[i].innerHTML = "save";
        })
    }
}
function addSingleGame()
{

}
