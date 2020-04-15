const UserList = document.querySelector('#user-list');

//This function appends all of the queried information to HTML table
function renderAccount(doc){
    let tr = document.createElement('tr');
    let id = document.createElement('td');
    let first = document.createElement('td');
    let last = document.createElement('td');
    let major = document.createElement('td');
    let year = document.createElement('td');
    let room_number = document.createElement('td');
    let room_letter = document.createElement('td');

    tr.setAttribute('data-id', doc.id);
    id.textContent = doc.id;
    first.textContent = doc.data().first;
    last.textContent = doc.data().last;
    major.textContent = doc.data().major;
    year.textContent = doc.data().year;
    room_number.textContent = doc.data().room_number;
    room_letter.textContent = doc.data().room_letter;

    tr.appendChild(id);
    tr.appendChild(first);
    tr.appendChild(last);
    tr.appendChild(major);
    tr.appendChild(year);
    tr.appendChild(room_number);
    tr.appendChild(room_letter);

    UserList.appendChild(tr);
}

//This function clears out HTML table of rows
function delete_table(){
   var table = document.getElementById("user-list");
   while(table.rows.length > 1) {
    table.deleteRow(1);
  }
}

// This function provides the functionality for display all residents button
function query_all(){
    delete_table();
    db.collection("Residents").get().then(function(querySnapshot) {
        querySnapshot.forEach(function(doc) {
            renderAccount(doc);
        });
    });
}

//This function queries based on resident ID
function query_id(){
    delete_table();
    var form = document.getElementById("query_id");
    var id = form.elements.namedItem("id").value;
    console.log(id);
    db.collection("Residents").where(firebase.firestore.FieldPath.documentId(), '==', id).get().then(function(querySnapshot){
        querySnapshot.forEach(function(doc) {
        renderAccount(doc);
        });
    });
    form.reset();
}
//This was the test function to query all Computer Science Majors
function run(){
    delete_table();
    db.collection("Residents").where('major', '==', 'Computer Science').get().then(function(querySnapshot) {
        querySnapshot.forEach(function(doc) {
            renderAccount(doc);
        });
    });
}















/* Testing out new query code here */

function single_query(collection,form,param){
    var value = form.elements.namedItem(param).value;
    var comp = "=="
    if(value == ""){
        comp = ">=";
    }
    console.log(param,comp,value);
    var ids = new Array();
    collection.where(param, comp, value)
    .get()
    .then(function(querySnapshot) {
        querySnapshot.forEach(function(doc) {
            //console.log(doc.data());
            ids.push(doc.id);
        });
    })
    return ids;
}

function query(){
    var collection = db.collection("Residents");
    var form = document.getElementById("query");

    set1 = single_query(collection,form,"first");
    set2 = single_query(collection,form,"last");
    set3 = single_query(collection,form,"major");
    set4 = single_query(collection,form,"year");
    set5 = single_query(collection,form,"room_number");
    set6 = single_query(collection,form,"room_letter");

    setTimeout(() => {
        x=set1.filter(value => -1 !== set2.indexOf(value));
        x=x.filter(value => -1 !== set3.indexOf(value));
        x=x.filter(value => -1 !== set4.indexOf(value));
        x=x.filter(value => -1 !== set5.indexOf(value));
        x=x.filter(value => -1 !== set6.indexOf(value));
        setTimeout(print_set(x), 1000);
    }, 2000);

    form.reset();
}

// Trying to assign golbal variable that saves the item in the set, but not working
var test;
function print_set(set){
    for (item in set){
        console.log(set[item]);  
        test = set[item]; 
    }      
}

console.log(test);  



//This function should print out the query based on the saved "test" variable, but not working
function query_id_test(){
    delete_table();
    //var form = document.getElementById("query_id");
    //var id = form.elements.namedItem("id").value;
    //console.log(id);
    db.collection("Residents").where(firebase.firestore.FieldPath.documentId(), '==', test).get().then(function(querySnapshot){
        querySnapshot.forEach(function(doc) {
        renderAccount(doc);
        });
    });
    form.reset();
}