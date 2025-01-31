import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function ProductDetails() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/products/${id}`)
      .then((response) => {
        setProduct(response.data);
      })
      .catch((error) => {
        console.error("Fehler beim Abrufen des Produkts:", error);
      });
  }, [id]);

  if (!product) return <div>Lädt...</div>;

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-bold mb-4">{product.name}</h1>
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
        <img src={product.image} alt={product.name} className="w-full h-96 object-cover" />
        <div>
          <p className="text-gray-600 mb-4">{product.description}</p>
          <p className="font-bold text-lg mb-4">${product.price}</p>
          <button className="bg-blue-500 text-white px-4 py-2 rounded">In den Warenkorb</button>
        </div>
      </div>
    </div>
  );
}

export default ProductDetails;
