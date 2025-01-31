import { Link } from "react-router-dom";

function ProductCard({ product }) {
  return (
    <div className="border rounded-lg shadow-lg p-4">
      <img src={product.image} alt={product.name} className="w-full h-48 object-cover mb-4" />
      <h2 className="text-xl font-semibold">{product.name}</h2>
      <p className="text-gray-600">{product.description}</p>
      <p className="font-bold text-lg mt-2">${product.price}</p>
      <Link to={`/product/${product.id}`} className="text-blue-500 hover:underline mt-4 block">Details</Link>
    </div>
  );
}

export default ProductCard;
