function solution(order) {
    return order.toString().replace(/[^3,6,9]/g, "").length;
}