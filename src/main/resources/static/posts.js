const React = require('react');
const client = require('./client');

class PostList extends React.Component {
		constructor(props) {
		super(props);
		this.state = {posts: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/posts'}).done(response => {
			this.setState({posts: response.entity._embedded.posts});
		});
	}

	render() {
		var posts = this.state.posts.map(post =>
			<Post key={post._links.self.href} post={post}/>
		);
		return (
			<table>
				<thead>
					<tr>
						<th>Publish Date</th>
						<th>Title</th>
						<th>URI</th>
					</tr>
				</thead>
				{posts}
			</table>
		)
	}
}

class Post extends React.Component{
	render() {
		return (
			<tbody>
				<tr>
					<td>{this.props.post.publishDate}</td>
					<td>{this.props.post.title}</td>
					<td>{this.props.post.uri}</td>
				</tr>
				<tr>
					<td colSpan="3">{this.props.post.body}</td>
				</tr>
			</tbody>
		)
	}
}

module.exports = PostList;
