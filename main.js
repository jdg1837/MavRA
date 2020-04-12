function add(){
    var form = document.getElementById("add");
    // Get input values from each of the form elements
    var id = form.elements.namedItem("id").value;
    var fname = form.elements.namedItem("fname").value;
    var lname = form.elements.namedItem("lname").value;
    var major = form.elements.namedItem("major").value;
    var year = form.elements.namedItem("year").value;
    var room_number = form.elements.namedItem("room_number").value;
    var room_letter = form.elements.namedItem("room_letter").value;

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
}
  
function del(){
    var form = document.getElementById("remove");
    var id = form.elements.namedItem("id").value;
    window.alert(id);
    db.collection("Residents").doc(id).delete()
}