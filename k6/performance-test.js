import http from 'k6/http';

export const options = {
    vus: 5,
    duration: '20s',
};

export default function () {
    const orderId = Math.floor(Math.random() * 1000000);
    const paymentId = Math.floor(Math.random() * 1000000);
    const userId =  Math.floor(Math.random() * (5 - 1 + 1)) + 1;


    const payload = JSON.stringify({
        orderId: orderId,
        paymentId: paymentId,
        productId: 999,
        userId: userId,
        category: "FOOD",
        quantity: 1
    });

    const params = {
        headers: { 'Content-Type': 'application/json' }
    };

    http.post(
        "http://host.docker.internal:8080/api/payment/completion",
        payload,
        params
    );
}
