window.onload = async function(){
    let response = await fetch(`${domain}/session`);
    let responseBody = await response.json();

    if(responseBody.success){
        window.location = "./dashboard";
    }
}


/* function that runs when the page loads */
document.getElementById("login-form").addEventListener("submit", async function (event){
    //this is to stop the form from reloading 
    event.preventDefault();
    
    //retrieve input elements from the dom
    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");

    //get values from the input elements and put it into an object
    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value
    }

    //send the http request
    let response = await fetch(`${domain}/session`, {
        method: "POST",
        body: JSON.stringify(user)
    })

    //retrieve the response body
    let responseBody = await response.json();


    //logic after response body
    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        console.log("Login Successful",responseBody.data)
        if(responseBody.data.roleId == 2) {
            window.location = "managerDashboard?userId=" + responseBody.data.id
            //window.location = `./managerDashboard?userId=${responseBody.data.id}`
        } else {
            window.location = "employeeDashboard?userId=" + responseBody.data.id
            //window.location = `./employeeDashboard?userId=${responseBody.data.id}`
        }

        //redirect page to dashboard page if credentials were successful

       // window.location = "./dashboard?userId=" + responseBody.data.id
       //http://localhost:9001/dashboard?userId=4
       // window.location = `./dashboard?userId=${responseBody.data.id}`

    }


})