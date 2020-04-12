// db.collection('Residents').get().then((snapshot)=>{
//   snapshot.docs.forEach( doc => {
//     console.log(doc.data())
//   })
// })




function test2(){
  window.alert("Hello");

}


function test (){


  window.alert("Hello");

  db.collection("Residents").add({
  first: "Ada",
  last: "Lovelace",
  born: 1815
  })
  .then(function(docRef) {
      console.log("Document written with ID: ", docRef.id);
  })
  .catch(function(error) {
      console.error("Error adding document: ", error);
  });
}




function add() {

    window.alert("Hello");

    // Get input values from each of the form elements
    var id = $("#id").val();

    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var major = $("#major").val();
    var year = $("#year").val();
    var room_number = $("#room_number").val();
    var room_letter = $("#room_letter").val();

    // Add a new document in collection "cities"
    db.collection("Residents").doc(id).set({
      first: fname,
      last: lname,
      major: major,
      room:{
        number: room_number,
        side: room_letter
      },
      year: year
    })
    .then(function() {
    console.log("Document successfully written!");
    })
    .catch(function(error) {
    console.error("Error writing document: ", error);
    });
/*
    let resident_data = {
        first: fname,
        last: lname,
        major: major,
        room: {
            number: room_number,
            side: room_letter
        },
        year: year
    };
    residents.doc(id).set(resident_data);
*/
}

function del(){
  db.collection("Residents").doc("1001401837").delete().then(function() {
    console.log("Document successfully deleted!");
}).catch(function(error) {
    console.error("Error removing document: ", error);
});
}
