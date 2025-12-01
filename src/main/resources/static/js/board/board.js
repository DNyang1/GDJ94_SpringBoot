const fileAdd = document.getElementById("fileAdd");
const files = document.getElementById("files");

let idx = 1;

files.addEventListener("click", (e) => {
	let d = e.target;
	if (d.classList.contains("del")) {
		document.getElementById(d.getAttribute("data-id")).remove();
		idx--;
	}

})

fileAdd.addEventListener("click", () => {
    if (idx > 5) {
        alert("5개까지하쇼");
        return;
    }

	let div = document.createElement("div")
	let input = document.createElement("input")

	let id = "file" + idx;
	div.id = id;

	input.type = "file";
	input.name = "attach";

	let button = document.createElement("button")
	button.classList.add("del")
	button.type = "button"
	button.textContent = "X"

	button.setAttribute("data-id", id);
	div.append(input)
	div.append(button)
	files.append(div);
	idx++
})
