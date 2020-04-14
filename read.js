const UserList = document.querySelector('#user-list');

            function renderAccount(doc){
                let tr = document.createElement('tr');
                let first = document.createElement('td');
                let last = document.createElement('td');
                let major = document.createElement('td');
                let year = document.createElement('td');
                let room_number = document.createElement('td');
                let room_letter = document.createElement('td');

                tr.setAttribute('data-id', doc.id);
                first.textContent = doc.data().first;
                last.textContent = doc.data().last;
                major.textContent = doc.data().major;
                year.textContent = doc.data().year;
                room_number.textContent = doc.data().room_number;
                room_letter.textContent = doc.data().room_letter;

                tr.appendChild(first);
                tr.appendChild(last);
                tr.appendChild(major);
                tr.appendChild(year);
                tr.appendChild(room_number);
                tr.appendChild(room_letter);

                UserList.appendChild(tr);

            }

db.collection("Residents").get().then(function(querySnapshot) {
    querySnapshot.forEach(function(doc) {
        // doc.data() is never undefined for query doc snapshots
        //console.log(doc.id, " => ", doc.data());
        renderAccount(doc);
    });
});