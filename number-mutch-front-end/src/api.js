const API_URL = "http://localhost:8080/api/game";

export const newGame = async () => {
  const res = await fetch(`${API_URL}/new`);
  const game = await res.json();
  console.log(game);
  return game;
};

export const matchCells = async (r1, c1, r2, c2) => {
  const res = await fetch(
    `${API_URL}/match?r1=${r1}&c1=${c1}&r2=${r2}&c2=${c2}`,
    { method: "POST" }
  );
  return res.json();
};

export const addLines = async () => {
  const res = await fetch(`${API_URL}/add-lines`, { method: "POST" });
  return res.json();
};
