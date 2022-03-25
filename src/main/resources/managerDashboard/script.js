/* Dashboard javascript */
let user;

window.onload = async function() {

    //this is used to retrieve query param
    let response = await fetch(`${domain}/session`);

    let responseBody = await response.json();



    user = responseBody.data; // "some_value"

    getAllReimbursements();
}

async function getAllReimbursements(){
    
    let response = await fetch(`${domain}/reimbursement?userId=${user.id}`);

    let responseBody = await response.json();

    console.log(responseBody)

    let reimbursement = responseBody.data;


    reimbursement.forEach(reimbursement => {
        createList(reimbursement)
    });
}