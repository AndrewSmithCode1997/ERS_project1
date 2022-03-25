let user;

window.onload = async function() {

    //this is used to retrieve query param
    let response = await fetch(`${domain}/session`);

    let responseBody = await response.json();



    console.log(responseBody.data)

    user = responseBody.data; // "some_value"

    getAllReimbursements();
}

async function getAllReimbursements() {
    let response = await fetch(`${domain}/reimbursement?userId=${user.id}`);

    let responseBody = await response.json();

    console.log(responseBody)

    let reimbursements = responseBody.data;

    reimbursements.forEach(reimbursement => {
        createList(reimbursement)
    })
}

function createList(reimbursement){

    let listContainerElem = document.getElementById("list-container");

    let listCardElem = document.createElement("div");
    listCardElem.className = "list-card"

    listCardElem.innerHTML = `
        <div class="list-title">${reimbursement.description}</div>
        <div class="img-container">
            <img src="./cart.png" alt="cart">
        </div>
        <div class="list-btns">
            <button id="view-btn-${reimbursement.id}" class="btn btn-primary" onclick=viewList(event)>View</button>
            <button id="delete-btn-${reimbursement.id}" class="delete-btn" onclick=deleteList(event)><div>x</div></button>
        </div>`

    listContainerElem.appendChild(listCardElem);

}