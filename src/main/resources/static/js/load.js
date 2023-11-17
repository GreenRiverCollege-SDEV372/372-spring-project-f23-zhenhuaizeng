/*
*  Author : ZhenHuai Zeng
*  Data: 11/15/2023
*  File Name: load.js
*  Description: This JavaScript file adds a table to admin page, and it has a few functions which pull the data from
* backend and display them on the admin page.

* */


/*
*
* This is a window.onload function, it allows users to be able to click on the edit, delete, and add buttons.
*
* */
window.onload = async function() {
    await fetchGames();
    let button = document.getElementById("button");
    let oldEditLinks = document.querySelectorAll(".edit");
    let oldDeleteLinks = document.querySelectorAll(".delete");
    for (let i = 0; i < oldDeleteLinks.length; i++) {
        oldDeleteLinks[i].onclick = deleteHandler;
    }
    for (let i = 0; i < oldEditLinks.length; i++) {
        oldEditLinks[i].onclick = function (event) {
            if (oldEditLinks[i].textContent === 'Edit') {
                oldEditLinks[i].textContent = 'Save';
                editHandler(event);
            } else {
                oldEditLinks[i].textContent = 'Edit';
                change(event);
            }
        };
    }
    button.addEventListener("click",async function (event) {
        await addRecord(event);
        let editLinks = document.querySelectorAll(".edit");
        let deleteLinks = document.querySelectorAll(".delete");
        for (let i = 0; i < deleteLinks.length; i++) {
            deleteLinks[i].onclick = deleteHandler;
        }
        for (let i = 0; i < editLinks.length; i++) {
            editLinks[i].onclick = function (event) {
                if (editLinks[i].textContent === 'Edit') {
                    editLinks[i].textContent = 'Save';
                    editHandler(event);
                } else {
                    editLinks[i].textContent = 'Edit';
                    change(event);
                }
            };
        }

    });

}


/*
*  This is a change function, basically it is getting the data from users' input and send it to the backend as an object.
*  Then, it changes the data of a row on the table.
*
* */
async function change(event)
{
    event.preventDefault();
    let row = event.target.parentElement.parentElement;
    let rows = document.querySelectorAll("tbody tr");
    let editRecord = {
        id: parseInt(row.children[0].textContent),
        name : document.querySelector("input#Name").value,
        genres :document.querySelector("input#genres").value,
        platforms :document.querySelector("input#platforms").value,
        developers : document.querySelector("input#developers").value
    };
    let uri = "http://localhost:8080/games/edition";
    let config =
        {
            method : "PUT",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(editRecord)
        };
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
/*
*  This is an edit function, when users click on the edit button,it changes a row of table to blank column, so
* the users can enter new information about a game.
* */
function editHandler(event)
{
    event.preventDefault();
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
/*
*   This is a delete function. It takes a row from users, and then it delete the data and the row.
*
* */
async function deleteHandler(event) {
    event.preventDefault();
    let row = event.target.parentElement.parentElement;
    let tbody = row.parentElement;
    let deleteId =
        {
            id: parseInt(row.children[0].textContent)
        };
    let uri = "http://localhost:8080/games/deletion";
    let config = {
        method: "delete",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(deleteId)
    };
    await fetch(uri, config);
    tbody.removeChild(row);
}
/*
*  This is a addRecord function. first, it takes data from users' input from a form, and then, it adds the elements that
* users put in to the table and database.
*
*
*
* */
async function addRecord(event) {
    //this step is correct
    event.preventDefault();
    let newRecord = {
        name : document.querySelector("input#GName").value,
        genres :document.querySelector("input#Genres").value,
        platforms :document.querySelector("input#Platforms").value,
        developers : document.querySelector("input#Developers").value
    };
    let uri = "http://localhost:8080/games/addition";
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
}

/*
*  This is an addElement function. It creates a table by using appendChild function. the function gets data from JSON
* ,and it displays the data on the table.
*
* */
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
    edit.innerHTML = '<td><a class = "edit" href = "#" >Edit</a></td>';
    deletee.innerHTML= '<td><a class = "delete" href = "#">Delete</a></td>';
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

/*
*  This function's name is fetchGames. it gets data from backend and passes them to addElement function, then the
* addElement function will display a table filled with data from the backend.
*
* */
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





