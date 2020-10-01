import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function App() {
  const [dados, setDados] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/mediaIdadeSanguineo")
      .then((data) => data.json())
      .then((data) => {
        console.log(data);
        setDados(data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <div className="container">
      <nav>
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
      </nav>
      <ul>
        {console.log(dados)}
        {dados.length > 0 ? (
          dados.map((data, index) => (
            <li key={index}>
              <p>
                Tipo Sanguíneo:{" "}
                {JSON.stringify(data.tipoSanguineo).replace(/"/g, "")}
              </p>
              <p>Média da idade: {JSON.stringify(data.mediaIdade)}</p>
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
