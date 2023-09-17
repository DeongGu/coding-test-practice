function solution(tickets) {
  const answer = [];
  
  const graph = {};
  for (const [from, to] of tickets) {
    if (!graph[from]) graph[from] = [];
    graph[from].push(to);
  }
  
  for (const key in graph) {
    graph[key].sort();
  }
  
  function dfs(node) {
    const dests = graph[node];
    while (dests && dests.length > 0) {
      const nextNode = dests.shift();
      dfs(nextNode);
    }
    answer.unshift(node);
  }
  
  dfs("ICN");
  
  return answer;
}