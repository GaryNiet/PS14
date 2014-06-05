package characters;

import gui.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import logic.Variables;
import places.Place;

public class Animation
{
	double roamX;
	double roamY;
	double aimX;
	double aimY;
	double norm;
	boolean moving;

	Node firstNode;
	Node lastNode;

	List<Node> path;

	Random random;
	AbstractCharacter character;

	public Animation(AbstractCharacter parent)
	{
		character = parent;
		roamX = 10;
		roamY = 10;
		aimX = 11;
		aimY = 11;
		norm = 1;
		random = new Random();
		moving = false;

		path = new ArrayList<>();
		firstNode = new Node();
		lastNode = new Node();
	}

	public synchronized void updateRoam(Place place)
	{
		if (moving == true)
		{
			if (path.size() != 0)
			{
				aimX = -(character.getCurrentPlace().getPosX() - path.get(0)
						.getPosX());
				aimY = -(character.getCurrentPlace().getPosY() - path.get(0)
						.getPosY());
			}

			double distX = roamX - (double) aimX;
			double distY = roamY - (double) aimY;

			norm = Math.sqrt(Math.abs(distX * distX + distY * distY));
			double divisionX = distX / norm;
			double divisionY = distY / norm;

			if (norm <= 10 && norm >= -10)
			{
				if (path.size() != 0)
				{
					path.remove(0);
				} else
				{
					moving = false;
				}
			}

			// double destDistX = roamX - lastNode.getPosX();
			// double destDistY = roamY - lastNode.getPosY();
			// double distToDest = Math.sqrt(Math.abs(destDistX*destDistX +
			// destDistY * destDistY));
			// if(distToDest <= 10 && distToDest >= -10)
			// {
			// moving = false;
			// }

			roamX -= divisionX/1.5;
			roamY -= divisionY/1.5;

		} else
		{
			double distX = roamX - (double) aimX;
			double distY = roamY - (double) aimY;

			norm = Math.sqrt(Math.abs(distX * distX + distY * distY));
			double divisionX = distX / norm;
			double divisionY = distY / norm;

			if (norm <= 10 && norm >= -10)
			{
				choseRandomSpot(place);
			}

			roamX -= divisionX / 2;
			roamY -= divisionY / 2;
		}

	}

	private synchronized void createPath()
	{
		path.clear();

		firstNode.setExplored(true);

		Stack<Node> s = new Stack<>();
		s.push(firstNode);
		firstNode.setExplored(true);

		while (!s.isEmpty())
		{
			Node n = (Node) s.peek();

			if (n.getPosX() == lastNode.getPosX()
					&& n.getPosY() == lastNode.getPosY())
			{
				while (!s.isEmpty())
				{
					path.add(0, s.pop());
				}
			}

			Node child = getUnvisitedChildNode(n, lastNode);

			if (child != null)
			{
				child.setExplored(true);
				s.push(child);
			} else
			{
				if (s.size() > 0)
				{
					s.pop();
				}

			}
		}

		// Clear visited property of nodes
		for (Node node : getNodeList())
		{
			node.setExplored(false);
		}

	}

	private Node getUnvisitedChildNode(Node node, Node lastNode)
	{

		List<Node> nodes = new ArrayList<>();
		for (Node childNode : node.getNodes())
		{
			if (childNode.isExplored() == false)
			{
				nodes.add(childNode);
			}
		}
		if (nodes.size() > 0)
		{
			int distance = 10000;
			Node returnNode = new Node();
			for (Node bestNode : nodes)
			{
				if (nodeDistance(bestNode, lastNode) < distance)
				{
					distance = nodeDistance(node, lastNode);
					returnNode = bestNode;

				}

			}
			return returnNode;
		} else
		{
			return null;
		}

	}

	private int nodeDistance(Node nodeStart, Node nodeDest)
	{
		return Math.abs(nodeStart.getPosX() - nodeDest.getPosX())
				+ Math.abs(nodeStart.getPosY() - nodeDest.getPosY());
	}

	private void choseRandomSpot(Place place)
	{
		aimX = random.nextInt(place.getSizeX());
		aimY = random.nextInt(place.getSizeY());
	}

	public Node findFirstNode()
	{
		Node returnNode = new Node();

		int distance = 10000;
		for (Node node : Variables.getGameLogic().getUserInterface()
				.getGameMap().getNodes())
		{
			int dist = (int) (Math.abs((character.getPosX() + roamX)
					- node.getPosX()) + Math.abs((character.getPosY() + roamY)
					- node.getPosY()));
			if (dist < distance)
			{
				distance = dist;
				returnNode = node;
			}
		}
		return returnNode;
	}

	public Node findLastNode()
	{
		List<Node> possibleReturnNodes = new ArrayList<>();
		Node returnNode = new Node();

		for (Node node : getNodeList())
		{
			if (node.getPlace() != null)
			{
				if (node.getPlace().getPosX() == character.currentPlace
						.getPosX())
				{
					possibleReturnNodes.add(node);
				}
			}
		}

		int dist = 10000;
		for (Node bestNode : possibleReturnNodes)
		{
			if (nodeDistance(bestNode, firstNode) < dist)
			{
				dist = nodeDistance(bestNode, firstNode);
				returnNode = bestNode;
			}
		}
		return returnNode;
	}

	public double getRoamX()
	{
		return roamX;
	}

	public double getRoamY()
	{
		return roamY;
	}

	public boolean isMoving()
	{
		return moving;
	}

	public void setMoving()
	{
		if (moving == true)
		{
			moving = false;
		} else
		{
			moving = true;

			firstNode = findFirstNode();
			lastNode = findLastNode();

			createPath();
			System.out.println("size: " + path.size());

			roamX += character.getPosX()
					- character.getCurrentPlace().getPosX();
			roamY += character.getPosY()
					- character.getCurrentPlace().getPosY();
		}

	}

	private List<Node> getNodeList()
	{
		// System.out.println("_____________________________________________________________");
		// for(Node node:
		// Variables.getGameLogic().getUserInterface().getGameMap().getNodes())
		// {
		// System.out.println(node.getPosX() + " " + node.getPosY());
		// }
		// System.out.println("_____________________________________________________________");
		return Variables.getGameLogic().getUserInterface().getGameMap()
				.getNodes();
	}

}
