function query_id(){
    var form = document.getElementById("query_id");
    var id = form.elements.namedItem("id").value;
    var resident = db.collection("Residents").doc(id).get();
    console.log(resident.data());
    form.reset();
}

function query(){
    var collection = db.collection("Residents");
    var form = document.getElementById("query");

    var fname = form.elements.namedItem("fname").value;
    var first_comp = "=="
    if(fname == ""){
        first_comp = ">=";
    }
    var lname = form.elements.namedItem("lname").value;
    var last_comp = "=="
    if(lname == ""){
        last_comp = ">=";
    }
    var major = form.elements.namedItem("major").value;
    var major_comp = "=="
    if(major == ""){
        major_comp = ">=";
    }
    var year = form.elements.namedItem("year").value;
    var year_comp = "=="
    if(year == ""){
        year_comp = ">=";
    }
    var room_number = form.elements.namedItem("room_number").value;
    var number_comp = "=="
    if(room_number == ""){
        number_comp = ">=";
    }
    var room_letter = form.elements.namedItem("room_letter").value;
    var number_comp = "=="
    if(room_letter == ""){
        number_comp = ">=";
    }

    collection.where("first", first_comp, fname).where("last", last_comp, lname).where("major", major_comp, major).where("year", year_comp, year)
    .get()
    .then(function(querySnapshot) {
     querySnapshot.forEach(function(doc) {
         // doc.data() is never undefined for query doc snapshots
         console.log(doc.id, " => ", doc.data());
        });
    });

    form.reset();
}
