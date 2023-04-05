function solution(order) {
  const boxCount = order.length; // 택배상자의 개수
  const boxes = new Array(boxCount); // 각 택배상자의 현재 위치를 저장할 배열
  for (let i = 0; i < boxCount; i++) {
    boxes[i] = i + 1; // 각 택배상자의 위치 초기화
  }
  let truckIndex = 0; // 트럭에 실린 상자의 개수
  let boxIndex = 0; // 현재 실을 상자의 인덱스
  const storage = []; // 보조 컨테이너 벨트에 보관 중인 상자들의 위치를 저장할 배열
  while (truckIndex < boxCount && boxIndex < boxCount) {
    if (boxes[boxIndex] === order[truckIndex]) { // 트럭에 실을 순서가 되면
      truckIndex++; // 상자를 트럭에 싣고
      boxIndex++; // 다음 상자를 실을 준비
      while (storage.length > 0 && storage[storage.length - 1] === order[truckIndex]) { // 보조 컨테이너 벨트에 있는 상자를 우선적으로 실을 수 있는지 확인
        storage.pop(); // 상자를 꺼내서 트럭에 싣고
        truckIndex++; // 다음 상자를 트럭에 실을 준비
      }
    } else {
      storage.push(boxes[boxIndex]); // 트럭에 실을 순서가 아니면 보조 컨테이너 벨트에 보관
      boxIndex++; // 다음 상자를 실을 준비
    }
  }
  return truckIndex; // 트럭에 실린 상자의 개수 반환
}