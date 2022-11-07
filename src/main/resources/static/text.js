console.log('js goes')

const connectionBtn = document.getElementById('connectionBtn');
const disconnectionBtn = document.getElementById('disconnectionBtn');
const ipInput = document.getElementById('connectionInput');

const sendInput = document.getElementById('sendInput');
const sendBtn = document.getElementById('sendBtn');

let ws;

connectToWs = () => {
    ws = new WebSocket('ws://' + ipInput.value);
    ws.onopen = () => {
        connectionDisabler(false);
    };
    ws.onerror = () => {
        throw new Error('Error with the connection!');
    }
}

const ip = localStorage.getItem('ip');

if ( ip !== null){
    console.log('hell')
    ipInput.value = ip;
    localStorage.removeItem('ip')
    connectToWs();
}

connectionDisabler = (state) => {
    disconnectionBtn.disabled = state;
    sendInput.disabled = state;
    sendBtn.disabled = state;

    ipInput.disabled = !state;
    connectionBtn.disabled = !state;
}

connectionDisabler(true);

connectionBtn.addEventListener("click", ev => {
    connectToWs();
})

disconnectionBtn.addEventListener('click',ev => {
    ws.close();
    connectionDisabler(true);
    localStorage.removeItem('ip')
})

sendBtn.addEventListener('click', ev => {
    ws.send(sendInput.value);
    sendInput.value = '';
})

refresh = () =>{
    if (ws.readyState === 1 ){
        localStorage.setItem('ip', ipInput.value);

    }
}
