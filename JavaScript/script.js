//JavaScript Basics & Setup

console.log("Welcome to the community portal");
window.onload=function(){
alert("Page loaded");
}

//2. Syntax, Data Types, and Operators

const name="Music fest";
const date="19 may 2026";
let seats=50;

console.log(`Event name : ${name}
    Event date : ${date}
    Available seats : ${seats}`);

    seats--;
    console.log("After Registration : ");
    console.log(`Available seats : ${seats}`);

    seats++;
    console.log("After cancellation ");
    console.log(`Available seats : ${seats}`);


//3. Conditionals, Loops, and Error Handling

const events =[
    {
        name:"Music fest",
        date : "2026-06-10",
        seats : 20
    },

    {
        name:"Dance fest",
        date:"2024-02-15",
        seats : 15
    },

    {
        name : "Food fest",
        date : "2026-07-02",
        seats: 0
    }
];

//store the current date
const today = new Date();

//display the valid events
events.forEach(function(event){
    const eventDate = new Date(event.date);
    if(eventDate > today && event.seats > 0){
        console.log(`
           Event name : ${event.name}
           Event Date : ${event.date}
           Available seats : ${event.seats} `);
    }
    else{
        console.log(`${event.name} is not available`);
    }
});

//Registration
try{
    let registrationSeats=1;
    if(registrationSeats <= 0){
        throw new Error("Seats not Available");
    }
    else{
        registrationSeats--;
        console.log("Registration successful");
    }
}
catch(error){
    console.log("Registration Failed");
    console.log(error.message);
}

//4. Functions, Scope, Closures, Higher-Order Functions
const eventss=[];

//add event
function addEvent(name , category){
    eventss.push(
        {
            name : name,
            category : category
        }
    );
    console.log(`${name} Added`);
}

//register user
function registerUser(username , eventname){
    console.log(`${username} registered in ${eventname}`);
}

//filter events
function filterEvent(category,callback){
    const filtered = eventss.filter(function(event){
        return event.category == category;
    })
    callback(filtered);
}

//closure
function registrationTracker(){
    let totalReg = 0;
    return function(){
        totalReg++;
        console.log(`Total registrations: ${totalReg}`);
    };
}

//add events here
addEvent("Music fest","Music");
addEvent("Dance fest","Dance");
addEvent("Food fest","Food");

//register user here
registerUser("Vasavi","Music fest");

//closure tracking is here
const musicTracker = registrationTracker();
musicTracker();
musicTracker();
musicTracker();

//callback function - fixed to use filtered array
function displayEvents(filteredEvents){
    console.log("Filtered events : ");
    filteredEvents.forEach(function(event){
        console.log(event.name);
    });
}

//filter category
filterEvent("Music",displayEvents);


//5. Objects and Prototypes
function Event(name,date,seats){
    this.name=name;
    this.date=date;
    this.seats=seats;
}

//prototype method
Event.prototype.checkAvailability=function(){
    if(this.seats > 0){
        console.log(`${this.name} : seats available`);
    }
    else{
        console.log(`${this.name} Event full`);
    }
};

//create objects here
const event1 = new Event("Music Fest","2026-06-10",20);
const event2 = new Event("Food Carnival","2026-07-15",0);

event1.checkAvailability();
event2.checkAvailability();

//display events here 
console.log("Object Entries");
Object.entries(event1).forEach(function(item){
    console.log(item[0]," : ",item[1]);
});

//6. Arrays and Methods
const events1 =[
    {
        name:"Music fest",
        category: "Music"
    },

    {
        name:"Dance show",
        category: "Dance"
    },

    {
        name : "Workshop on baking",
        category : "Food"
    }
];

//add event
events1.push({
    name:"live band",
    category : "Music"
});

console.log("All Events : ");
console.log(events1); // fixed from event1

//filter music events
const musicEvent =events1.filter(function(event){
    return event.category === "Music"
});

console.log("Music events");
console.log(musicEvent);

//format display cards
const eventCards =events1.map(function(event){
    return `Event Card : ${event.name}`;
});

console.log("Display Cards");
console.log(eventCards);

//7. DOM Manipulation
const communityEvents = [
    {
        name: "Music Fest",
        category: "Music",
        seats: 20
    },

    {
        name: "Dance Show",
        category: "Dance",
        seats: 15
    },

    {
        name: "Food Festival",
        category: "Food",
        seats: 10
    }
];

// Access DOM Element
const container = document.querySelector("#eventContainer");

// Display Events
function renderEvents(eventsToRender){
    container.innerHTML = ""; // clear before render
    eventsToRender.forEach(function(event){
        const card = document.createElement("div");
        card.className = "card";
        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>Category : ${event.category}</p>
            <p>Seats : <span class="seatCount">${event.seats}</span></p>
        `;

        // Register Button
        const registerBtn = document.createElement("button");
        registerBtn.textContent = "Register";
        registerBtn.onclick = function(){
            if(event.seats > 0){
                event.seats--;
                card.querySelector(".seatCount").textContent = event.seats;
            }
            else{
                alert("No seats available");
            }
        };

        // Cancel Button
        const cancelBtn = document.createElement("button");
        cancelBtn.textContent = "Cancel";
        cancelBtn.onclick = function(){
            event.seats++;
            card.querySelector(".seatCount").textContent = event.seats;
        };

        card.appendChild(registerBtn);
        card.appendChild(cancelBtn);
        container.appendChild(card);
    });
}

renderEvents(communityEvents); // initial render

//8. Event Handling
const categoryFilter = document.querySelector("#categoryFilter");
const searchInput = document.querySelector("#searchInput");

// onchange Event
categoryFilter.onchange = function(){
    const selectedCategory = categoryFilter.value;
    console.log("Selected Category :", selectedCategory);
    
    if(selectedCategory === "All"){
        renderEvents(communityEvents);
    } else {
        const filtered = communityEvents.filter(e => e.category === selectedCategory);
        renderEvents(filtered);
    }
};

// keydown Event
searchInput.onkeyup = function(){ // changed to onkeyup for live search
    const searchTerm = searchInput.value.toLowerCase();
    const filtered = communityEvents.filter(e => e.name.toLowerCase().includes(searchTerm));
    renderEvents(filtered);
};

// 9. Async JavaScript, Promises, Async/Await
const loading = document.querySelector("#loading");

// Using Fetch + then + catch
loading.style.display = "block";
fetch("https://jsonplaceholder.typicode.com/users")
.then(function(response){
    return response.json();
})
.then(function(data){
    console.log("Data Received Successfully");
    console.log(data);
    loading.style.display = "none";
})
.catch(function(error){
    console.log("Error Occurred");
    console.log(error);
    loading.style.display = "none";
});

// Using Async / Await
async function fetchEvents(){
    try{
        loading.style.display = "block";
        const response = await fetch("https://jsonplaceholder.typicode.com/users");
        const data = await response.json();
        console.log("Async/Await Data");
        console.log(data);
        loading.style.display = "none";
    }
    catch(error){
        console.log("Error Occurred");
        console.log(error);
        loading.style.display = "none";
    }
}
fetchEvents();

// Promise Example
const registrationPromise = new Promise(function(resolve,reject){
    let registrationSuccess = true;
    if(registrationSuccess){
        resolve("Registration Successful");
    }
    else{
        reject("Registration Failed");
    }
});

registrationPromise
.then(function(message){
    console.log(message);
})
.catch(function(error){
    console.log(error);
});

// 10. Modern JavaScript Features
// const and let
const portalName = "Local Community Event Portal";
let totalEvents = 3;
console.log(portalName);
console.log(`Total Events : ${totalEvents}`);

// Default Parameters
function addNewEvent(name = "Unknown Event", category = "General"){
    console.log(`Event Name : ${name}`);
    console.log(`Category : ${category}`);
}

// Function Calls
addNewEvent("Music Fest","Music");
addNewEvent();

// Destructuring
const eventObj = {
    name : "Dance Show",
    category : "Dance",
    seats : 20
};

const { name: dName, category: dCategory, seats: dSeats } = eventObj;
console.log("Destructuring Output");
console.log(dName);
console.log(dCategory);
console.log(dSeats);

// Spread Operator
const eventsSpread = [
    { name:"Music Fest", category:"Music" },
    { name:"Dance Show", category:"Dance" },
    { name:"Food Festival", category:"Food" }
];

// Clone Array
const clonedEvents = [...eventsSpread];

// Filter Music Events
const musicEvents = clonedEvents.filter(function(event){
    return event.category === "Music";
});
console.log("Music Events");
console.log(musicEvents);

// 11 & 12. Working with Forms + AJAX & Fetch API - merged into one
const form = document.querySelector("#registrationForm");
const errorMessage = document.querySelector("#errorMessage");
const successMessage = document.querySelector("#successMessage");

form.onsubmit = function(event){
    // Prevent Page Refresh
    event.preventDefault();

    // Get Form Values
    const userName = form.elements["userName"].value;
    const email = form.elements["email"].value;
    const eventName = form.elements["eventName"].value;

    // Clear Messages
    errorMessage.textContent = "";
    successMessage.textContent = "";

    // Validation
    if(userName === "" || email === "" || eventName === ""){
        errorMessage.textContent = "Please fill all fields";
        return;
    }

    // Success + AJAX
    successMessage.textContent = "Submitting Registration...";

    setTimeout(function(){
        fetch("https://jsonplaceholder.typicode.com/posts",{
            method : "POST",
            headers : { "Content-Type": "application/json" },
            body : JSON.stringify({ userName : userName, email : email, eventName : eventName })
        })
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            console.log("Server Response");
            console.log(data);
            successMessage.textContent = `${userName} successfully registered for ${eventName}`;
        })
        .catch(function(error){
            console.log(error);
            errorMessage.textContent = "Registration Failed";
        });
    },2000);
};

// 14. jQuery and JS Frameworks
$(document).ready(function(){
    // Click Event
    $("#registerBtn").click(function(){
        $("#eventContainer").fadeIn();
        console.log("Events Displayed");
    });

    // Hide Events
    $("#hideBtn").click(function(){
        $("#eventContainer").fadeOut();
        console.log("Events Hidden");
    });
});