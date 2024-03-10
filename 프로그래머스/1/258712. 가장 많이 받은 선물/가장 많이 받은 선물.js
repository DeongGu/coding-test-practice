function solution(friends, gifts) {
  const result = [];
  const giftNumber = {};

  const friendsIndex = {};
  friends.forEach((friend, idx) => {
    friendsIndex[friend] = idx;
    giftNumber[idx] = [0, 0, 0];
    result[idx] = 0;
  });

  const list = Array.from({ length: friends.length })
    .fill()
    .map(() => Array(friends.length).fill(0));

  gifts.forEach((gift) => {
    const [give, take] = gift.split(" ");
    list[friendsIndex[give]][friendsIndex[take]]++;
    giftNumber[friendsIndex[give]][0]++;
    giftNumber[friendsIndex[take]][1]++;
    giftNumber[friendsIndex[give]][2] =
      giftNumber[friendsIndex[give]][0] - giftNumber[friendsIndex[give]][1];
    giftNumber[friendsIndex[take]][2] =
      giftNumber[friendsIndex[take]][0] - giftNumber[friendsIndex[take]][1];
  });

  friends.forEach((friend, idx) => {
    for (let i = idx; i < friends.length; i++) {
      if (idx === i) continue;

      if (list[idx][i] > list[i][idx]) {
        result[idx]++;
      } else if (list[idx][i] < list[i][idx]) {
        result[i]++;
      } else {
        if (giftNumber[idx][2] > giftNumber[i][2]) {
          result[idx]++;
        }
        if (giftNumber[idx][2] < giftNumber[i][2]) {
          result[i]++;
        }
      }
    }
  });

  return Math.max(...result);
}
