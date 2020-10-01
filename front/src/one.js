import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function App() {
  const [dados, setDados] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/quantity")
      .then((data) => data.json())
      .then((data) => {
        // console.log(data);
        setDados(data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <div className="container">
      <div className="buttons">
        <Link to="1">
          <button>1</button>
        </Link>
        <Link to="2">
          <button>2</button>
        </Link>
        <Link to="3">
          <button>3</button>
        </Link>
        <Link to="4">
          <button>4</button>
        </Link>
      </div>
      <ul>
        {console.log(dados)}
        {dados.length > 0 ? (
          dados.map((data, index) => (
            <li key={index}>
              <p>Estado: {JSON.stringify(data.nomeEstado).replace(/"/g, "")}</p>
              <p>
                Quantidade por estado: {JSON.stringify(data.quantidadeEstado)}
              </p>
            </li>
          ))
        ) : (
          <h1>Carregando...</h1>
        )}
      </ul>
    </div>
  );
}

export default App;
