import { useState, useEffect } from "react";
import { newGame, matchCells, addLines } from "../api";

export default function GameBoard() {
  const [game, setGame] = useState(null);
  const [selected, setSelected] = useState(null);

  useEffect(() => {
    startGame();
  }, []);

  const startGame = async () => {
    const data = await newGame();
    setGame(data);
    if (!localStorage.getItem("bestScore")) {
      localStorage.setItem("bestScore", data.score);
    }
  };

  const clickCell = async (r, c) => {
    if (!game.grid[r][c].value) return;

    if (!selected) {
      setSelected({ r, c });
    } else {
      const data = await matchCells(selected.r, selected.c, r, c);
      setGame(data);
      if (data.score > localStorage.getItem("bestScore")) {
        localStorage.setItem("bestScore", data.score);
      }
      setSelected(null);
    }
  };

  const handleAddLines = async () => {
    const data = await addLines();
    setGame(data);
  };

  if (!game) return <p className="p-6">Loading...</p>;

  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 p-6">
      <div className="max-w-3xl mx-auto">
        <h1 className="text-2xl font-bold mb-4">Number Match DAIA</h1>

        <div className="flex gap-6 text-sm text-slate-300 mb-4">
          <span>
            Score: <b className="text-slate-100">{game.score}</b>
          </span>
          <span>
            Best Score:{" "}
            <b className="text-slate-100">
              {localStorage.getItem("bestScore") || 0}
            </b>
          </span>
          <span>
            Remaining Lines:{" "}
            <b className="text-slate-100">{game.remainingLines}</b>
          </span>
        </div>

        <div
          className="grid gap-2  p-3 rounded-xl border border-slate-800 w-fit overflow-auto h-[450px]"
          style={{
            gridTemplateColumns: `repeat(${game.grid[0].length}, 56px)`,
          }}
        >
          {game.grid.map((row, r) =>
            row.map((cell, c) => {
              const isEmpty = !cell.value;
              const isSelected = selected?.r === r && selected?.c === c;

              return (
                <button
                  key={`${r}-${c}`}
                  onClick={() => clickCell(r, c)}
                  className={[
                    "w-14 h-14 rounded-lg font-bold text-lg",
                    "border border-slate-800",
                    isEmpty
                      ? "bg-slate-950/40 text-slate-600 cursor-default"
                      : "bg-slate-950 hover:bg-slate-800",
                    isSelected ? "ring-2 ring-indigo-400" : "",
                  ].join(" ")}
                >
                  {cell.value || ""}
                </button>
              );
            })
          )}
        </div>

        <div className="mt-4 flex gap-3">
          <button
            onClick={handleAddLines}
            disabled={game.remainingLines === 0}
            className="px-4 py-2 rounded-lg bg-indigo-500 hover:bg-indigo-400 disabled:opacity-50 disabled:cursor-not-allowed"
          >
             Add 3 Lines
          </button>

          <button
            onClick={startGame}
            className="px-4 py-2 rounded-lg border border-slate-800 bg-slate-900 hover:bg-slate-800"
          >
            New Game
          </button>
        </div>

        {game.gameOver && (
          <p className="mt-4 font-bold text-rose-400">GAME OVER</p>
        )}
      </div>
    </div>
  );
}
