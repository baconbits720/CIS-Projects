const vehicleLog = [
    {
        make: "BMW",
        model: "M3 Competition",
        year: 2022,
        bought: "2025-04-15",
        isAuto: true,
        regState: "Pennsylvania",
        city: 16,
        highway: 23,
        label() {
            return `${this.year} ${this.make} ${this.model}`;
        },
        avgMPG() {
            return ((this.city + this.highway) / 2).toFixed(1);
        },
        niceDate() {
            return new Date(this.bought).toLocaleDateString("en-US", {
                year: "numeric",
                month: "short",
                day: "numeric"
            });
        }
    }
];

const vehicleList = document.getElementById("vehicleList");

function showVehicle(v) {
    const card = document.createElement("div");
    card.className = "vehicle-card";

    const title = document.createElement("h3");
    title.textContent = v.label();

    const info = document.createElement("p");
    info.innerHTML = `
        <strong>Combined MPG:</strong> ${v.avgMPG()}<br>
        <strong>Purchased:</strong> ${v.niceDate()}<br>
        <strong>Transmission:</strong> ${v.isAuto ? "Automatic" : "Manual"}<br>
        <strong>Registered:</strong> ${v.regState}
    `;

    card.appendChild(title);
    card.appendChild(info);
    vehicleList.appendChild(card);
}

vehicleLog.forEach(showVehicle);

document.getElementById("logBtn").addEventListener("click", () => {
    const first = document.getElementById("inputFirst").value.trim();
    const last = document.getElementById("inputLast").value.trim();
    const year = parseInt(document.getElementById("inputYear").value);
    const make = document.getElementById("inputMake").value.trim();
    const model = document.getElementById("inputModel").value.trim();
    const trans = document.getElementById("inputTrans").value;
    const mpg = parseFloat(document.getElementById("inputMPG").value);
    const state = document.getElementById("inputState").value.trim();

    if (first && last) {
        document.getElementById("registeredOwner").textContent = `Owner: ${first} ${last}`;
    }

    const entry = {
        make,
        model,
        year,
        bought: new Date().toISOString(),
        isAuto: trans === "auto",
        regState: state,
        city: mpg,
        highway: mpg,
        label() {
            return `${this.year} ${this.make} ${this.model}`;
        },
        avgMPG() {
            return ((this.city + this.highway) / 2).toFixed(1);
        },
        niceDate() {
            return new Date(this.bought).toLocaleDateString("en-US", {
                year: "numeric",
                month: "short",
                day: "numeric"
            });
        }
    };

    showVehicle(entry);
});
