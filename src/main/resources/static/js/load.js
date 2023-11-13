window.onload = async function() {
    await fetchGames();
    //await fetchBehavior();
    let button = document.querySelector("#button");
    button.onclick = addRecord;
    let deleteLinks = document.querySelectorAll(".delete");
    for (let i = 0; i < deleteLinks.length; i++) {
        deleteLinks[i].onclick = deleteHandler;
    }
    let editLinks = document.querySelectorAll(".edit");

    for (let i = 0; i < editLinks.length; i++) {
        editLinks[i].onclick = function(event) {
            // Toggle the text content based on the current text
            if (editLinks[i].textContent === 'Edit') {
                editLinks[i].textContent = 'Save';
                edit(event);
            } else {
                editLinks[i].textContent = 'Edit';
                change(event);
            }
        };
    }

}
async function change(event)
{
    let row = event.target.parentElement.parentElement;
    let rows = document.querySelectorAll("tbody tr");
    let editRecord = {
        id: parseInt(row.children[0].textContent),
        name : document.querySelector("input#Name").value,
        genres :document.querySelector("input#genres").value,
        platforms :document.querySelector("input#platforms").value,
        developers : document.querySelector("input#developers").value
    };
    let uri = "http://localhost:8080/editGames";
    let config =
        {
            method : "PUT",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(editRecord)
        };
    console.log(editRecord);
    let response = await fetch(uri,config);
    let json =  await response.json();
    let tdId = row.children[0];
    for (let i = 0; i < rows.length; i++) {
        let tr = rows[i];
        //access the child elements of our <tr>?
        if (tdId === tr.children[0]) {
            tr.children[2].textContent = json.name;
            tr.children[3].textContent = json.genres;
            tr.children[4].textContent = json.platforms;
            tr.children[5].textContent = json.developers;
        }
    }

}
function edit(event)
{
    let row = event.target.parentElement.parentElement;
    let rows = document.querySelectorAll("tbody tr");
    let tdId = row.children[0];
    for (let i = 0; i < rows.length; i++) {
        let tr = rows[i];
        //access the child elements of our <tr>?

        if (tdId === tr.children[0]) {
            tr.children[2].innerHTML = '<td><input class = "change" id="Name"></td>';
            tr.children[3].innerHTML = '<td><input class = "change" id="genres"></td>';
            tr.children[4].innerHTML = '<td><input class = "change" id="platforms"></td>';
            tr.children[5].innerHTML = '<td><input class = "change" id="developers"></td>';
        }
    }
}

async function deleteHandler(event) {
    event.preventDefault();
    let row = event.target.parentElement.parentElement;
    let deleteId =
        {
            id: parseInt(row.children[0].textContent)
        };
    let uri = "http://localhost:8080/deleteGames";
    let config = {
        method: "delete",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(deleteId)
    };
    await fetch(uri, config);
    location.reload();

}

async function addRecord() {
    let newRecord = {
        name : document.querySelector("input#GName").value,
        genres :document.querySelector("input#Genres").value,
        platforms :document.querySelector("input#Platforms").value,
        developers : document.querySelector("input#Developers").value
    };
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
    let section = document.querySelector("#row");
    addElement(json,section);
    location.reload();
}

async function fetchGames()
{
    let uri = "http://localhost:8080/games";
    let config = {
        method : "get"
    };

    let response = await fetch(uri,config);
    let json = await response.json();
    let section = document.querySelector("#row");
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
    edit.innerHTML = '<td><a class = "edit" href = "#" > Edit </a></td>';
    deletee.innerHTML= '<td><a class = "delete" href = "#"> Delete </a></td>';
    let tableRow = document.createElement("tr");
    tableRow.appendChild(id);
    tableRow.appendChild(date);
    tableRow.appendChild(name);
    tableRow.appendChild(genres);
    tableRow.appendChild(platforms);
    tableRow.appendChild(developer);
    tableRow.appendChild(edit);
    tableRow.appendChild(deletee);
    section.appendChild(tableRow);
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




