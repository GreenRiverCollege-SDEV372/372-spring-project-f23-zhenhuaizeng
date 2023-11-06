window.onload = async function(){
    await fetchIcons();
}

async function fetchIcons()
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
    }
}

function addElement(element, section)
{
    let paragraph = document.createElement("p");
    paragraph.innerText = "Games' name: " + element.name;
    section.appendChild(paragraph);
}